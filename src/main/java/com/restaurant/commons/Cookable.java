package com.restaurant.commons;

import java.util.concurrent.Future;

public interface Cookable {

    long cook();
    Future<Long> cookAsync();
}
