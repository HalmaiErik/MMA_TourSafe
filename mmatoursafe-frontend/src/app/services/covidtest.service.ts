import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CovidTest } from '../model/covidtest';

@Injectable({
  providedIn: 'root'
})
export class CovidtestService {
  private apiServerUrl = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public addTestForFighter(test: CovidTest, fighterId: number): Observable<CovidTest> {
    test.idFighter = fighterId;
    return this.http.post<CovidTest>(`${this.apiServerUrl}/covidtest/fighter/${fighterId}`, test)
  }
}
