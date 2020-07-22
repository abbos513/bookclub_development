package uz.pdp.userregistertest.service;


import uz.pdp.userregistertest.model.Result;
import uz.pdp.userregistertest.payload.RegisterReq;

public interface UserService {
    Result saveUser(RegisterReq registerReq);
}