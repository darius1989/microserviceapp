package it.aesys.customer;

import lombok.Builder;
import lombok.Data;



public record CustomerRegistrationRequest( String firstName,String lastName,String email){}
