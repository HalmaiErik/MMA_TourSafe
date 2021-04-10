import { Fighter } from "./fighter";
import { Match } from "./match";

export interface Tournament {
    id: number;
    name: string;
    startDate: string;
    endDate: string;
    schedule: string;
}