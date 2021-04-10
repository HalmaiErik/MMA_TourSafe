import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Fighter } from '../model/fighter';

@Injectable({
  providedIn: 'root'
})
export class FighterService {
  private apiServerUrl = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public addFighter(fighter: Fighter, tournamentId: number): Observable<Fighter> {
    fighter.idTournament = tournamentId;
    return this.http.post<Fighter>(`${this.apiServerUrl}/fighters/tournament/${tournamentId}`, fighter);
  }
}
