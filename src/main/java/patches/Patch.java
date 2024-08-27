/*     */ package patches;
/*     */ import EgoMod.HomuraMod;
import cards.M84;
/*     */ import cards.M870;
import cards.No1;
import cards.No2;
import cards.No3;
import cards.No4;
import cards.No5;
import cards.No6;
import cards.No7;
/*     */ import cards.No8;
/*     */ import cards.No9;
import cards.No10;
import cards.No11;
import cards.No12;
import cards.No13;
import cards.No14;
import cards.No15;
import cards.Prepare;
import cards.M18A1;
import cards.DesertEagle;
import cards.M92;
import cards.M249;
import cards.TimeBomb;
import cards.IED;
import cards.FlashBang;
import cards.Smoke;
import cards.AT4;
import cards.FuelTankCar;
/*     */ import cards.SSM1;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.cards.colorless.TheBomb;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class Patch {
/*     */   public static int countCurse() {
/*  16 */     int count = 0;
/*  17 */     Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
/*     */ 
/*     */     
/*  20 */     while (var1.hasNext()) {
/*  21 */       AbstractCard c = var1.next();
/*  22 */       if (c.type == AbstractCard.CardType.CURSE) {
/*  23 */         count++;
/*     */       }
/*     */     } 
/*  26 */     var1 = AbstractDungeon.player.drawPile.group.iterator();
/*     */     
/*  28 */     while (var1.hasNext()) {
/*  29 */       AbstractCard c = var1.next();
/*  30 */       if (c.type == AbstractCard.CardType.CURSE) {
/*  31 */         count++;
/*     */       }
/*     */     } 
/*  34 */     var1 = AbstractDungeon.player.discardPile.group.iterator();
/*  35 */     while (var1.hasNext()) {
/*  36 */       AbstractCard c = var1.next();
/*  37 */       if (c.type == AbstractCard.CardType.CURSE) {
/*  38 */         count++;
/*     */       }
/*     */     } 
/*  41 */     return count;
/*     */   }
/*     */   public static int countSL() {
/*  44 */     return HomuraMod.getSaveLoadCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int isServant(AbstractCard c) {
/*  49 */     switch (c.cardID) { case "No1":
/*  50 */         return 1;
/*  51 */       case "No2": return 2;
/*  52 */       case "No3": return 3;
/*  53 */       case "No4": return 4;
/*  54 */       case "No5": return 5;
/*  55 */       case "No6": return 6;
/*  56 */       case "No7": return 7;
/*  57 */       case "No8": return 8;
/*  58 */       case "No9": return 9;
/*  59 */       case "No10": return 10;
/*  60 */       case "No11": return 11;
/*  61 */       case "No12": return 12;
/*  62 */       case "No13": return 13;
/*  63 */       case "No14": return 14;
/*  64 */       case "No15": return 15; }
/*  65 */      return 0;
/*     */   }
/*     */   
/*     */   public static boolean[] countServantArr() {
/*  69 */     boolean[] Servant = new boolean[15];
/*  70 */     Arrays.fill(Servant, false);
/*     */     
/*  72 */     Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
/*     */     
/*  74 */     while (var1.hasNext()) {
/*  75 */       AbstractCard c = var1.next();
/*  76 */       int s = isServant(c);
/*  77 */       if (s != 0) {
/*  78 */         Servant[s - 1] = true;
/*     */       }
/*     */     } 
/*     */     
/*  82 */     var1 = AbstractDungeon.player.drawPile.group.iterator();
/*  83 */     while (var1.hasNext()) {
/*  84 */       AbstractCard c = var1.next();
/*  85 */       int s = isServant(c);
/*  86 */       if (s != 0) {
/*  87 */         Servant[s - 1] = true;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     var1 = AbstractDungeon.player.discardPile.group.iterator();
/*  92 */     while (var1.hasNext()) {
/*  93 */       AbstractCard c = var1.next();
/*  94 */       int s = isServant(c);
/*  95 */       if (s != 0) {
/*  96 */         Servant[s - 1] = true;
/*     */       }
/*     */     } 
/*     */     
/* 100 */     return Servant;
/*     */   }
/*     */   public static int countServantNum() {
/* 103 */     boolean[] hasServant = countServantArr();
/* 104 */     int count = 0;
/* 105 */     for (boolean value : hasServant) {
/* 106 */       if (value) {
/* 107 */         count++;
/*     */       }
/*     */     } 
/* 110 */     return count;
/*     */   }
/*     */   public static ArrayList<AbstractCard> getServant(int num) {
/* 113 */     int count = 0;
/* 114 */     ArrayList<AbstractCard> retVal = new ArrayList<>();
/* 115 */     AbstractCard No1 = (new No1()).makeCopy();
/* 116 */     AbstractCard No2 = (new No2()).makeCopy();
/* 117 */     AbstractCard No3 = (new No3()).makeCopy();
/* 118 */     AbstractCard No4 = (new No4()).makeCopy();
/* 119 */     AbstractCard No5 = (new No5()).makeCopy();
/* 120 */     AbstractCard No6 = (new No6()).makeCopy();
/* 121 */     AbstractCard No7 = (new No7()).makeCopy();
/* 122 */     AbstractCard No8 = (new No8()).makeCopy();
/* 123 */     AbstractCard No9 = (new No9()).makeCopy();
/* 124 */     AbstractCard No10 = (new No10()).makeCopy();
/* 125 */     AbstractCard No11 = (new No11()).makeCopy();
/* 126 */     AbstractCard No12 = (new No12()).makeCopy();
/* 127 */     AbstractCard No13 = (new No13()).makeCopy();
/* 128 */     AbstractCard No14 = (new No14()).makeCopy();
/* 129 */     AbstractCard No15 = (new No15()).makeCopy();
/* 130 */     AbstractCard[] ServantGroup = { No1, No2, No3, No4, No5, No6, No7, No8, No9, No10, No11, No12, No13, No14, No15 };
/* 131 */     boolean[] hasServant = countServantArr();
/*     */     
/* 133 */     for (int i = 0; i < 15; i++) {
/* 134 */       if (!hasServant[i]) {
/* 135 */         retVal.add(ServantGroup[i]);
/* 136 */         if (++count == num) {
/* 137 */           return retVal;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AbstractCard[] getArmsCard() {
/* 154 */     AbstractCard Prepare = (new Prepare()).makeCopy();
/* 155 */     AbstractCard M18A1 = (new M18A1()).makeCopy();
/*     */     
/* 157 */     AbstractCard DesertEagle = (new DesertEagle()).makeCopy();
/* 158 */     AbstractCard M92 = (new M92()).makeCopy();
/* 159 */     AbstractCard M249 = (new M249()).makeCopy();
/* 160 */     AbstractCard M870 = (new M870()).makeCopy();
/*     */     
/* 162 */     AbstractCard TheBomb = (new TheBomb()).makeCopy();
/* 163 */     AbstractCard TimeBomb = (new TimeBomb()).makeCopy();
/* 164 */     AbstractCard IED = (new IED()).makeCopy();
/* 165 */     AbstractCard FlashBang = (new FlashBang()).makeCopy();
/* 166 */     AbstractCard M84 = (new M84()).makeCopy();
/* 167 */     AbstractCard Smoke = (new Smoke()).makeCopy();
/*     */     
/* 169 */     AbstractCard AT4 = (new AT4()).makeCopy();
/* 170 */     AbstractCard SSM1 = (new SSM1()).makeCopy();
/* 171 */     AbstractCard FuelTankCar = (new FuelTankCar()).makeCopy();
/*     */     
/* 173 */     AbstractCard[] ArmsGroup = { Prepare, M18A1, DesertEagle, M92, M249, M870, TheBomb, TimeBomb, IED, FlashBang, M84, Smoke, AT4, SSM1, FuelTankCar };
/* 174 */     return ArmsGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int countHighlander() {
/* 179 */     ArrayList<String> cardIDS = new ArrayList<>();
/* 180 */     ArrayList<String> repeat = new ArrayList<>();
/* 181 */     for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
/* 182 */       if (!cardIDS.contains(c.cardID)) {
/* 183 */         cardIDS.add(c.cardID); continue;
/*     */       } 
/* 185 */       repeat.add(c.cardID);
/*     */     } 
/*     */     
/* 188 */     for (String ID : repeat) {
/* 189 */       cardIDS.remove(ID);
/*     */     }
/*     */     
/* 192 */     return cardIDS.size();
/*     */   }
/*     */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/patches/Patch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */