package com.simplon.dvdstore.dvdstore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Data
public class DvdStoreModel {

    List<DvdModel> dvds;
}
