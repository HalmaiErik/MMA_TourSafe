import { Component, OnInit } from '@angular/core';
import { FormsModule, FormBuilder, NgForm, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CovidTest } from '../model/covidtest';
import { CovidtestService } from '../services/covidtest.service';

@Component({
  selector: 'app-covidtest',
  templateUrl: './covidtest.component.html',
  styleUrls: ['./covidtest.component.css']
})
export class CovidtestComponent implements OnInit {
  idFighter: number;
  test: CovidTest = new CovidTest();
  result: number;

  constructor(private testService: CovidtestService, private route: ActivatedRoute,
    private fb: FormBuilder) { }

  registrationForm = this.fb.group({
    test: ['', [Validators.required]]
  })
  
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idFighter = +params['idfighter'];
      console.log(this.idFighter);
    });
  }

  onSubmit(): void {
    this.test.idFighter = this.idFighter;
    this.result = Number(this.registrationForm.get('test').value);
    if (this.result == 1) {
      this.test.result = true;
    }
    else {
      this.test.result = false;
    }
    this.testService.addTestForFighter(this.test, this.idFighter).subscribe(
      (resp: CovidTest) => {
        console.log(resp);
        alert("Succesful registration");
      }
    )
    
  }

}
