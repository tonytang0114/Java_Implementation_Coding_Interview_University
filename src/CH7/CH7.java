/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH7;

/**
 *
 * @author CITDBS
 */
public class CH7 {
    /*
    1)Handle ambiguity
        Who is going to use it and how they are going to use it.
        Who, what, where, when, how, why
    2)Define the core objects. 
    e.g. Restaurant ( Table, Guest, Party, Order, Meal, Employee, Server and Host)
    3)Analyze relationships
    e.g.i)   Party should have an array of Guests
        ii)  Server and Host inherit from Employee
        iii) Each Table has one Party, but each Party may have multiple tables
        iv) There is one Host for the restaurant
    4) Investigate Actions (how they relate to each other)
    For example, a Party walks into the Restaurant, and a Guest requests a Table from the Host. The
    Host looks up the Reservation and, if it exists, assigns the Party to a Table. Otherwise, the Party
    is added to the end of the list. When a Party leaves, the Table is freed and assigned to a new Party in
    the list.
    5)Design patterns
        i) Singleton
       ii) Factory
    */
}
