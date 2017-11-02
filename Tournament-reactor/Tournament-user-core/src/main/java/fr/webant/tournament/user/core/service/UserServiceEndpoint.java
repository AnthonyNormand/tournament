/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.webant.tournament.user.core.service;

import javax.sql.DataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.javalite.activejdbc.DB;

/**
 * @author anthony
 * Aspect which provides a database connection to every method of the service package
 */
@Aspect
class UserServiceEndpoint {
   
    /**
     * Around each methods of the service : open and close the database connection
     * @param joinPoint around each methods of the service package
     * @return the result of the called method
     * @throws Throwable 
     */
    @Around("execution(* fr.webant.tournament.user.core.service.UserService.*(..))")
    public Object manageDatabaseConnection(ProceedingJoinPoint joinPoint) throws Throwable {
        
        //FIXME Use a native pool or not?
        try(DB db = new DB()) {
            db.open();
            return joinPoint.proceed();
        }
    }
}
