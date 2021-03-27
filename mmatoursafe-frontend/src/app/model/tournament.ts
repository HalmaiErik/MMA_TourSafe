import { Fighter } from "./fighter";
import { Match } from "./match";

export interface Tournament {
    id: number;
    name: string;
    fighters: Fighter[];
    matches: Match[];
    startDate: string;
    endDate: string;
}