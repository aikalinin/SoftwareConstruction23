package org.hse.software.construction.cinema.service;

import com.google.common.collect.ImmutableBiMap;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.devh.boot.grpc.server.service.GrpcService;
import org.hse.software.construction.cinema.CinemaServiceGrpc.CinemaServiceImplBase;
import org.hse.software.construction.cinema.TicketsRequest;
import org.hse.software.construction.cinema.TicketsResponse;

@GrpcService
public class CinemaServiceImpl extends CinemaServiceImplBase {

  private final Map<String, List<LocalDateTime>> dataStorage = ImmutableBiMap.of(
      "Oppenheimer",
      Arrays.asList(LocalDateTime.of(2024, 1, 1, 0, 0),
          LocalDateTime.of(2024, 2, 1, 12, 0)),
      "Breaking Bad",
      List.of(LocalDateTime.now())
  );

//    new HashMap() {{
//    put(, new ArrayList<LocalDateTime>() {{
//      add(LocalDateTime.of(2024, 1, 1, 0, 0));
//      add(LocalDateTime.of(2024, 2, 1, 12, 0));
//    }});
//    put("Breaking Bad", new ArrayList<LocalDateTime>() {{
//      add(LocalDateTime.now());
//    }});
//  }};

  @Override
  public void getTickets(TicketsRequest request, StreamObserver<TicketsResponse> responseObserver) {
    Optional<List<LocalDateTime>> dates = Optional.ofNullable(
        dataStorage.get(request.getCinemaName()));

    dates.ifPresent(value -> value.forEach(date -> responseObserver.onNext(
        TicketsResponse.newBuilder()
            .setDate(localDateTimeToTimestamp(date))
            .build())));

    responseObserver.onCompleted();
  }

  private Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime) {
    java.time.Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

    return Timestamp.newBuilder()
        .setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano())
        .build();
  }
}
