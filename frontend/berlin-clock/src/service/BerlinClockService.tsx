export default class BerlinClockService {

    convertTimeRepresentation(time :Date ) : Promise<string> {
        return fetch(`convert/fromCurrentTime?time=${time.toLocaleTimeString()}`)
        .then(
            (time) => {return time.text()}
        );
    }
}