import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Fighter } from '../model/fighter';
import { Match } from '../model/match';
import { Tournament } from '../model/tournament';
import { TournamentService } from '../services/tournament.service';

@Component({
  selector: 'app-tournamentmatches',
  templateUrl: './tournamentmatches.component.html',
  styleUrls: ['./tournamentmatches.component.css']
})
export class TournamentmatchesComponent implements OnInit {
  matches: Match[] = [];
  quarantineFighters: Fighter[] = [];
  bubbleFighters: Fighter[] = [];
  idTournament: number;
  invitationLink: string;
  tournament: Tournament;
  private frontURL = environment.frontBaseURL;

  constructor(private tournamentService: TournamentService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idTournament = +params['id'];
      console.log(this.idTournament);
    });

    this.getTournament();
    this.invitationLink = `${this.frontURL}/tournament/${this.idTournament}/invitation`
    this.getQuarantinedFighters();
    this.getBubbleFighters();
    this.getMatches();
  }

  public onOrganizeMatches(): void {
    for (let i = 0; i < this.bubbleFighters.length - 1; i++) {
      for (let j = i + 1; j < this.bubbleFighters.length; j++) {
        if (this.bubbleFighters[i].weightClass == this.bubbleFighters[j].weightClass) {
          let insertMatch: Match = new Match();
          insertMatch.tournament = this.tournament;
          insertMatch.fighter1 = this.bubbleFighters[i];
          insertMatch.fighter2 = this.bubbleFighters[j];
          console.log(insertMatch);
          this.tournamentService.addMatch(insertMatch).subscribe(
            (resp: Match) => {
              console.log(resp);
            }
          );
        }
      }
    }
    this.ngOnInit();
  }

  public getTournament(): void {
    this.tournamentService.getTournament(this.idTournament).subscribe(
      (resp: Tournament) => {
        this.tournament = resp;
      }
    );
  }
  
  public getQuarantinedFighters(): void {
    this.tournamentService.getTournamentPositiveFighters(this.idTournament).subscribe(
      (resp: Fighter[]) => {
        this.quarantineFighters = resp;
        console.log(this.quarantineFighters);
      }
    );
  }

  public getBubbleFighters(): void {
    this.tournamentService.getTournamentNegativeFighters(this.idTournament).subscribe(
      (resp: Fighter[]) => {
        this.bubbleFighters = resp;
        console.log(this.bubbleFighters);
      }
    );
  }

  public getMatches(): void {
    this.tournamentService.getTournamentMatches(this.idTournament).subscribe(
      (resp: Match[]) => {
        this.matches = resp;
        console.log(this.matches);
      }
    );
  } 

}
