package com.kpo.springshaurma.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class Order {

    private List<Shaurma> shaurmaList = new ArrayList<>();

    public void addShaurma(Shaurma shaurma) {
        this.shaurmaList.add(shaurma);
    }
}
