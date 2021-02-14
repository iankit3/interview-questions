/**
 * Problem Statement

 
    |-O-|    |-O-|    |-O-|    |-O-|    |-O-|

    Above you see a tiny fraction of our glorious imperial fleet, the Twin Ion Engine starfighters (known as "TIE fighters" for short).

    Each TIE fighter consists of two solar array wings ('|'), two wing braces ('-') and one central cabin ('O').

    Even though our TIE fighters are clearly superior to the X-wing fighters flown by those pesky rebels, occasionally some TIE fighter will receive some accidental combat damage. Whenever a damaged TIE fighter is recovered, we disasemble it and salvage the parts that are still in working condition. It is now up to you to use these salvaged parts to assemble as many complete TIE fighters as possible.

    You are given the salvagedParts. Each character of salvagedParts represents one piece of machinery that has been salvaged. As mentioned above, the characters '|', '-', and 'O' (uppercase oh) represent the parts you need to build a TIE fighter.

    There may also be other characters in salvagedParts. These represent machinery that isn't used in a TIE fighter.

    Calculate and return the maximum number of TIE fighters you can assemble from the given parts. 
 */


public class TIEFighterAssembly {
    char solarArrayWing = '|';
    char wingBrace = '-';
    char centralRing = 'O';

    int[] count = { 0, 0, 0 };

    public int assemble(String salvagedParts) {
        for (char c : salvagedParts.toCharArray()) {
            if (c == solarArrayWing) {
                count[0]++;
            } else if (c == wingBrace) {
                count[1]++;
            } else if (c == centralRing) {
                count[2]++;
            }

            /**
             * if(count[0] >= 2 && count[1] >= 2 && count[2] >= 1){ tieFighterCount++;
             * count[0] -= 2; count[1] -= 2; count[2] -= 1; }
             */
        }

        return Math.min(Math.min(count[0] / 2, count[1] / 2), count[2]);
    }
}