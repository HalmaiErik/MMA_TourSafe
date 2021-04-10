import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Fighter } from '../model/fighter';
import { FighterService } from '../services/fighter.service';

@Component({
  selector: 'app-addfighter',
  templateUrl: './addfighter.component.html',
  styleUrls: ['./addfighter.component.css']
})
export class AddfighterComponent implements OnInit {
  idTournament: number;
  idFighter: number;

  constructor(private fighterService: FighterService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idTournament = +params['id'];
      console.log(this.idTournament);
    })
  }

  public onAddFighter(addForm: NgForm): void {
    document.getElementById('add-fighter-form')!.click();
    this.fighterService.addFighter(addForm.value, this.idTournament).subscribe(
      (response: Fighter) => {
        console.log(response);
        this.idFighter = response.id;
        this.goCovidTest();
      },
    );
  }

  public goCovidTest() {
    this.router.navigate([`/tournament/${this.idTournament}/invitation/${this.idFighter}/covidtest`]);
  }
}
