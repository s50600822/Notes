import { check } from "../src/check_braces";
describe("well", () => {
    it("() ok", () => {
      const well = check('()');
      expect(well).toEqual(true);
    });

    it("([]) ok", () => {
        const well = check('([])');
        expect(well).toEqual(true);
      });
  });

  describe("NOT well", () => {
    it("()] NOT ok", () => {
      const well = check('()]');
      expect(well).toEqual(false);
    });

    it("[([) NOT ok", () => {
        const well = check('[([)');
        expect(well).toEqual(false);
      });
  });  