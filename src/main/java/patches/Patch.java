package patches;

import EgoMod.HomuraMod;
import cards.AT4;
import cards.DesertEagle;
import cards.FlashBang;
import cards.FuelTankCar;
import cards.IED;
import cards.M18A1;
import cards.M249;
import cards.M84;
import cards.M870;
import cards.M92;
import cards.No1;
import cards.No10;
import cards.No11;
import cards.No12;
import cards.No13;
import cards.No14;
import cards.No15;
import cards.No2;
import cards.No3;
import cards.No4;
import cards.No5;
import cards.No6;
import cards.No7;
import cards.No8;
import cards.No9;
import cards.Prepare;
import cards.SSM1;
import cards.Smoke;
import cards.TimeBomb;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.colorless.TheBomb;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Patch {

  public static int countCurse() {
    int count = 0;
    Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();

    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.type == AbstractCard.CardType.CURSE) {
        count++;
      }
    }
    var1 = AbstractDungeon.player.drawPile.group.iterator();

    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.type == AbstractCard.CardType.CURSE) {
        count++;
      }
    }
    var1 = AbstractDungeon.player.discardPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      if (c.type == AbstractCard.CardType.CURSE) {
        count++;
      }
    }
    return count;
  }

  public static int countSL() {
    return HomuraMod.getSaveLoadCount();
  }

  public static int isServant(AbstractCard c) {
    switch (c.cardID) {
      case "No1":
        return 1;
      case "No2":
        return 2;
      case "No3":
        return 3;
      case "No4":
        return 4;
      case "No5":
        return 5;
      case "No6":
        return 6;
      case "No7":
        return 7;
      case "No8":
        return 8;
      case "No9":
        return 9;
      case "No10":
        return 10;
      case "No11":
        return 11;
      case "No12":
        return 12;
      case "No13":
        return 13;
      case "No14":
        return 14;
      case "No15":
        return 15;
    }
    return 0;
  }

  public static boolean[] countServantArr() {
    boolean[] Servant = new boolean[15];
    Arrays.fill(Servant, false);

    Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();

    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      int s = isServant(c);
      if (s != 0) {
        Servant[s - 1] = true;
      }
    }

    var1 = AbstractDungeon.player.drawPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      int s = isServant(c);
      if (s != 0) {
        Servant[s - 1] = true;
      }
    }

    var1 = AbstractDungeon.player.discardPile.group.iterator();
    while (var1.hasNext()) {
      AbstractCard c = var1.next();
      int s = isServant(c);
      if (s != 0) {
        Servant[s - 1] = true;
      }
    }

    return Servant;
  }

  public static int countServantNum() {
    boolean[] hasServant = countServantArr();
    int count = 0;
    for (boolean value : hasServant) {
      if (value) {
        count++;
      }
    }
    return count;
  }

  public static ArrayList<AbstractCard> getServant(int num) {
    int count = 0;
    ArrayList<AbstractCard> retVal = new ArrayList<>();
    AbstractCard No1 = (new No1()).makeCopy();
    AbstractCard No2 = (new No2()).makeCopy();
    AbstractCard No3 = (new No3()).makeCopy();
    AbstractCard No4 = (new No4()).makeCopy();
    AbstractCard No5 = (new No5()).makeCopy();
    AbstractCard No6 = (new No6()).makeCopy();
    AbstractCard No7 = (new No7()).makeCopy();
    AbstractCard No8 = (new No8()).makeCopy();
    AbstractCard No9 = (new No9()).makeCopy();
    AbstractCard No10 = (new No10()).makeCopy();
    AbstractCard No11 = (new No11()).makeCopy();
    AbstractCard No12 = (new No12()).makeCopy();
    AbstractCard No13 = (new No13()).makeCopy();
    AbstractCard No14 = (new No14()).makeCopy();
    AbstractCard No15 = (new No15()).makeCopy();
    AbstractCard[] ServantGroup = {
      No1,
      No2,
      No3,
      No4,
      No5,
      No6,
      No7,
      No8,
      No9,
      No10,
      No11,
      No12,
      No13,
      No14,
      No15,
    };
    boolean[] hasServant = countServantArr();

    for (int i = 0; i < 15; i++) {
      if (!hasServant[i]) {
        retVal.add(ServantGroup[i]);
        if (++count == num) {
          return retVal;
        }
      }
    }

    return retVal;
  }

  public static AbstractCard[] getArmsCard() {
    AbstractCard Prepare = (new Prepare()).makeCopy();
    AbstractCard M18A1 = (new M18A1()).makeCopy();

    AbstractCard DesertEagle = (new DesertEagle()).makeCopy();
    AbstractCard M92 = (new M92()).makeCopy();
    AbstractCard M249 = (new M249()).makeCopy();
    AbstractCard M870 = (new M870()).makeCopy();

    AbstractCard TheBomb = (new TheBomb()).makeCopy();
    AbstractCard TimeBomb = (new TimeBomb()).makeCopy();
    AbstractCard IED = (new IED()).makeCopy();
    AbstractCard FlashBang = (new FlashBang()).makeCopy();
    AbstractCard M84 = (new M84()).makeCopy();
    AbstractCard Smoke = (new Smoke()).makeCopy();

    AbstractCard AT4 = (new AT4()).makeCopy();
    AbstractCard SSM1 = (new SSM1()).makeCopy();
    AbstractCard FuelTankCar = (new FuelTankCar()).makeCopy();

    AbstractCard[] ArmsGroup = {
      Prepare,
      M18A1,
      DesertEagle,
      M92,
      M249,
      M870,
      TheBomb,
      TimeBomb,
      IED,
      FlashBang,
      M84,
      Smoke,
      AT4,
      SSM1,
      FuelTankCar,
    };
    return ArmsGroup;
  }

  public static int countHighlander() {
    ArrayList<String> cardIDS = new ArrayList<>();
    ArrayList<String> repeat = new ArrayList<>();
    for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
      if (!cardIDS.contains(c.cardID)) {
        cardIDS.add(c.cardID);
        continue;
      }
      repeat.add(c.cardID);
    }

    for (String ID : repeat) {
      cardIDS.remove(ID);
    }

    return cardIDS.size();
  }
}
/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/Patch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
