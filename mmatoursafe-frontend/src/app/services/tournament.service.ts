import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Tournament } from '../model/tournament';
import { Match } from '../model/match';
import { environment } from 'src/environments/environment';
import { Fighter } from '../model/fighter';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  private apiServerUrl = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public getTournaments(): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(`${this.apiServerUrl}`);
  }

  public addTournament(tournament: Tournament): Observable<Tournament> {
    return this.http.post<Tournament>(`${this.apiServerUrl}/add`, tournament);
  }

  public addMatch(match: Match): Observable<Match> {
    return this.http.post<Match>(`${this.apiServerUrl}/tournament/match/add`, match);
  }

  public getTournament(tournamentId: number): Observable<Tournament> {
    return this.http.get<Tournament>(`${this.apiServerUrl}/tournament/${tournamentId}`);
  }

  public getTournamentNegativeFighters(tournamentId: number): Observable<Fighter[]> {
    return this.http.get<Fighter[]>(`${this.apiServerUrl}/tournament/${tournamentId}/negativefighters`);
  }

  public getTournamentPositiveFighters(tournamentId: number): Observable<Fighter[]> {
    return this.http.get<Fighter[]>(`${this.apiServerUrl}/tournament/${tournamentId}/positivefighters`);
  }

  public getTournamentMatches(tournamentId: number): Observable<Match[]> {
    return this.http.get<Match[]>(`${this.apiServerUrl}/tournament/${tournamentId}/matches`);
  }
}
