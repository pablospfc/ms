package academy.digitallab.serviceproduct.controller;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ErrorMessage {

    private String code;
    private List<Map<String,String>> messages;
}
