package com.kgisl.sb103.entity;
 
import org.springframework.data.annotation.Id;
 
public record Person(@Id Long p_id, String p_name, String p_email) {
}
