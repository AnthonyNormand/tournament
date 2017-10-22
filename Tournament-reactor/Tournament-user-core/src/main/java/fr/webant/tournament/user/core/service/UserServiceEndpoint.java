/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.javalite.activejdbc.DB;

/**
 *
 * @author anthony
 */
@Aspect
class UserServiceEndpoint {
   
    @Around("execution(* fr.webant.tournament.user.core.service.UserService.*(..))")
    public Object manageDatabaseConnection(ProceedingJoinPoint joinPoint) throws Throwable {
        try(DB db = new DB()) {
            db.open();
            return joinPoint.proceed();
        }
    }
}
