package com.example.springBootEmelianov.beans.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PROTECTED)
public abstract class User implements IUser {

    @NonNull
    Integer state;

    Boolean isReadyToPay;

    @Override
    public void pay() {
        isReadyToPay = true;
    }

    @Override
    public void finish() {
        isReadyToPay = false;
    }
}
