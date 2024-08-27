/*    */ package relics;
/*    */ 
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class BlackLongbow extends CustomRelic {
/*    */   public static final String ID = "BlackLongbow";
/*    */   private static final String IMG = "img/relics/BlackLongbow.png";
/*    */   private static final String IMG_OTL = "img/relics/outline/BlackLongbow.png";
/*    */   
/*    */   public BlackLongbow() {
/* 24 */     super("BlackLongbow", ImageMaster.loadImage("img/relics/BlackLongbow.png"), ImageMaster.loadImage("img/relics/outline/BlackLongbow.png"), AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.CLINK);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atTurnStart() {
/* 30 */     flash();
/* 31 */     AbstractPlayer p = AbstractDungeon.player;
/* 32 */     AbstractMonster m = (AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 33 */     switch (AbstractDungeon.cardRandomRng.random(0, 2)) {
/*    */       case 0:
/* 35 */         if (m != null && !m.powers.isEmpty()) {
/* 36 */           ArrayList<AbstractPower> pows = new ArrayList<>();
/* 37 */           for (AbstractPower pow : m.powers) {
/* 38 */             if (pow.type == AbstractPower.PowerType.BUFF && 
/* 39 */               !pow.ID.equals("Fading") && 
/* 40 */               !pow.ID.equals("Shifting") && 
/* 41 */               !pow.ID.equals("Life Link"))
/*    */             {
/* 43 */               pows.add(pow);
/*    */             }
/*    */           } 
/* 46 */           if (!pows.isEmpty()) {
/* 47 */             AbstractPower po = pows.get((int)(Math.random() * pows.size()));
/* 48 */             AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, po));
/*    */             return;
/*    */           } 
/*    */         } 
/*    */       case 1:
/* 53 */         if (m != null) {
/* 54 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)m, -1), -1)); return;
/*    */         } 
/*    */         break;
/*    */     } 
/* 58 */     addToBot((AbstractGameAction)new GainEnergyAction(1));
/*    */   }
/*    */   public boolean canSpawn() {
/* 61 */     return AbstractDungeon.player.hasRelic("MetalShield");
/*    */   } public void obtain() {
/* 63 */     if (AbstractDungeon.player.hasRelic("MetalShield")) {
/* 64 */       AbstractDungeon.player.getRelic("MetalShield").onUnequip();
/* 65 */       instantObtain(AbstractDungeon.player, 0, false);
/*    */     } else {
/* 67 */       super.obtain();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 74 */     return this.DESCRIPTIONS[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractRelic makeCopy() {
/* 79 */     return (AbstractRelic)new BlackLongbow();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/BlackLongbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */