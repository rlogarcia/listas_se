package com.umanizales.list_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * en la clase niños por locacion se ve que las locaciones estan constituidas por una locacion y un contador
 */
public class BoysByLocation {
    private Location location;
    private int count;
}
