import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{
  Accounts!:any
  constructor(private http:HttpClient){}
  ngOnInit(): void {
    this.http.get("http://192.168.134.3:8888/ACCOUNT-SERVICE/accounts").subscribe(
      {
        next:(data)=>{
          this.Accounts=data
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
