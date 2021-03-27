import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Tournament } from '../model/tournament';
import { TournamentService } from '../services/tournament.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'MMA TourSafe';
  public tournaments: Tournament[] = [];
  public viewTournament: Tournament;

  constructor(private tournamentService: TournamentService, private router: Router) { }

  ngOnInit(): void {
    this.getTournaments();
  }

  public getTournaments(): void {
    this.tournamentService.getTournaments().subscribe(
      (resp: Tournament[]) => {
        this.tournaments = resp;
        console.log(this.tournaments);
      }
    )
  }

  public onAddTournament(addForm: NgForm): void {
    document.getElementById('add-tournament-form')!.click();
    this.tournamentService.addTournament(addForm.value).subscribe(
      (response: Tournament) => {
        console.log(response);
        this.getTournaments();
        addForm.reset();
      },
    );
  }

  public onOpenModal(tournament: Tournament, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addTournamentModal');
    }
    container!.appendChild(button);
    button.click();
  }

  public goMatches(idTournament: number) {
    this.router.navigate([`/tournament/${idTournament}`]);
  }

}
