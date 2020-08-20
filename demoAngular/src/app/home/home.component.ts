import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  data= [];
  constructor(private backendService: BackendService) { }

  ngOnInit(): void {
    this.backendService.get().subscribe((ret: any[])=>{
      console.log(ret);
      this.data = ret;
    })
  }

}
