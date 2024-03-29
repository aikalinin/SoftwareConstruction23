package ru.hse.software.construction.decorator;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class DefaultStudentService implements StudentService {

    private final Map<Integer, String> studentsProvider;

    @Override
    public List<String> getStudentsNames() {
        return studentsProvider.values().stream().toList();
    }

    @Override
    public Optional<String> getStudentNameById(Integer id) {
        return Optional.ofNullable(studentsProvider.get(id));
    }
}
