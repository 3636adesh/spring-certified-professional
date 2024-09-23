package com.common.time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.GregorianCalendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleDate implements Serializable {

    @Serial
    private static final long serialVersionUID = 2285962420279644602L;

    private GregorianCalendar base;
}