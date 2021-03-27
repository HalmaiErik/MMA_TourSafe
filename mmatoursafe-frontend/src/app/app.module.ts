import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TournamentmatchesComponent } from './tournamentmatches/tournamentmatches.component';
import { AddfighterComponent } from './addfighter/addfighter.component';
import { CovidtestComponent } from './covidtest/covidtest.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TournamentmatchesComponent,
    AddfighterComponent,
    CovidtestComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'tournament/:id', component: TournamentmatchesComponent },
      { path: 'tournament/:id/invitation', component: AddfighterComponent },
      { path: 'tournament/:idtournament/invitation/:idfighter/covidtest', component: CovidtestComponent },
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
