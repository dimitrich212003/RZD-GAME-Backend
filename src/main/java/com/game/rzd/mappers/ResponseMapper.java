package com.game.rzd.mappers;

public interface ResponseMapper<Res, M> {
    Res toResponse(M model);
}
