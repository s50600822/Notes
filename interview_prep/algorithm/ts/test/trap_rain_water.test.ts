import { trap } from "../src/trap_rain_water";
describe("water in da puddle", () => {
    it("[3, 0, 2, 0, 4] -> 7", () => {
      const trapped = trap([3, 0, 2, 0, 4]);
      expect(trapped).toEqual(7);
    });
  });