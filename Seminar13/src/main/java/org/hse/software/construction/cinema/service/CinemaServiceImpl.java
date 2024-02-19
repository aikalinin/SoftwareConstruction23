package org.hse.software.construction.cinema.service;

import com.google.common.collect.ImmutableBiMap;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

  @Override
  public void getTickets(TicketsRequest request, StreamObserver<TicketsResponse> responseObserver) {
    List<LocalDateTime> dates = dataStorage.get(request.getCinemaName());

    if (dates != null) {
      for (LocalDateTime date : dates) {
        responseObserver.onNext(
            TicketsResponse.newBuilder()
                .setDate(localDateTimeToTimestamp(date))
                .build());
      }
    }

    responseObserver.onCompleted();
  }

  @Override
  public void getTickets2(TicketsRequest request,
      StreamObserver<TicketsResponse> responseObserver) {
    try {
      final List<LocalDateTime> dates = dataStorage.get(request.getCinemaName());

      for (LocalDateTime date : dates) {
        responseObserver.onNext(
            TicketsResponse.newBuilder()
                .setDate(localDateTimeToTimestamp(date))
                .build());
      }

      responseObserver.onCompleted();
    } catch (Exception ex) {
      responseObserver.onError(Status.NOT_FOUND
          .withCause(ex)
          .withDescription("Something goes wrong")
          .asRuntimeException()
      );
    }
  }

  @Override
  public StreamObserver<TicketsRequest> getTickets3(
      StreamObserver<TicketsResponse> responseObserver) {
    return new StreamObserver<>() {
      @Override
      public void onNext(TicketsRequest ticketsRequest) {
        List<LocalDateTime> dates = dataStorage.get(ticketsRequest.getCinemaName());

        if (dates != null) {
          for (LocalDateTime date : dates) {
            responseObserver.onNext(
                TicketsResponse.newBuilder()
                    .setDate(localDateTimeToTimestamp(date))
                    .build());
          }
        }
      }

      @Override
      public void onError(Throwable throwable) {
        responseObserver.onError(throwable);
      }

      @Override
      public void onCompleted() {
        responseObserver.onCompleted();
      }
    };
  }

  private Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime) {
    java.time.Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

    return Timestamp.newBuilder()
        .setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano())
        .build();
  }
}
