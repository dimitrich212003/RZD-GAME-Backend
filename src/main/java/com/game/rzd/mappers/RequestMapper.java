package com.game.rzd.mappers;

public interface RequestMapper<Req, M> {
    M toModel(Req request);
}
