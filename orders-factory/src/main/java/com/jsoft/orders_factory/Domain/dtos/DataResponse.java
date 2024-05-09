package com.jsoft.orders_factory.Domain.dtos;

public record DataResponse(String[] errorMessages) {

    public boolean hasErrors(){
        return errorMessages != null && errorMessages.length>0;
    }

}
