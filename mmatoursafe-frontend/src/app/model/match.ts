import { Fighter } from "./fighter";
import { Tournament } from "./tournament";

export class Match {
    id: number;
    fighter1: Fighter;
    fighter2: Fighter;
    tournament: Tournament;
    dateTime: string;
}