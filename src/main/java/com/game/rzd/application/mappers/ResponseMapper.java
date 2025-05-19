package com.game.rzd.application.mappers;

public interface ResponseMapper<Res, M> {
    Res toResponse(M model);
}
