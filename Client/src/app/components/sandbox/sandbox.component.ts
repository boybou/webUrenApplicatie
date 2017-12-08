import { Component } from '@angular/core';
import { Customer } from './Customer';

@Component({
    selector: 'sandbox',
    templateUrl: './sandbox.component.html'
})

export class SandboxComponent{
    name = 'Vincent Spijkers';
    age = 19;
    person = {firstName: 'Vincent', lastName: 'Spijkers'}
    customer: Customer;

    constructor(){
        console.log('Constructor called....')
        this.customer = {
            id :1,
            name : 'Vincent Spijkers',
            email : 'vincent@vmail.com'
        }
        
    }

    hasBirthday(){
        this.age += 1;
    }

    showAge(){
        return this.age
    }

    createCustomer(){
        
    }
}

