package cloudapp.utils;

import cloudapp.entity.OperationType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class OperationParser {
    private OperationParser() {

    }

    public static List<OperationType> getOperationList(String input) {
        String[] split = input.split(";");
        return Arrays.asList(split).stream().map(str -> OperationType.valueOf(str)).collect(Collectors.toList());
    }
}
