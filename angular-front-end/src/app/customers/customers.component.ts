import { CommonModule } from '@angular/common';
import { HttpClient, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [
    CommonModule
  ],
  providers:[
  ],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  Customers!:any
  constructor(private http:HttpClient){}
  ngOnInit(): void {
    this.http.get("http://192.168.134.3:8888/CUSTOMER-SERVICE/customers").subscribe(
      {
        next:(data)=>{
          this.Customers=data
        },
        error:err=>{
          console.log('====================================');
          console.log(err);
          console.log('====================================');
        }
      }
    )
  }

}
