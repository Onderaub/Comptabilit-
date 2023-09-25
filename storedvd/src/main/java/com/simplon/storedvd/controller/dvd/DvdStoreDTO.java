package com.simplon.storedvd.controller.dvd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreDTO  {
    private Long id;
    private String name;
    private String genre;

}
