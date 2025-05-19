package com.game.rzd.application.mappers;

public interface RequestMapper<Req, M> {
    M toModel(Req request);
}
