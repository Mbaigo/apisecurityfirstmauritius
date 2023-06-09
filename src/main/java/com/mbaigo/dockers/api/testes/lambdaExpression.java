package com.mbaigo.dockers.api.testes;

import java.util.Comparator;

public class lambdaExpression implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare((Integer) o1, (Integer) o2);
    }
}
