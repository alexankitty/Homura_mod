/*    */ package relics;
/*    */ 
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class Mami
/*    */   extends CustomRelic {
/*    */   public static final String ID = "Mami";
/*    */   
/*    */   public Mami() {
/* 19 */     super("Mami", ImageMaster.loadImage("img/relics/Mami.png"), ImageMaster.loadImage("img/relics/outline/Mami.png"), AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.CLINK);
/*    */   }
/*    */   private static final String IMG = "img/relics/Mami.png"; private static final String IMG_OTL = "img/relics/outline/Mami.png";
/*    */   
/*    */   public void onPlayerEndTurn() {
/* 24 */     if (AbstractDungeon.cardRandomRng.random(0, 99) < 10) {
/* 25 */       AbstractPlayer p = AbstractDungeon.player;
/* 26 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)p, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onEquip() {
/* 33 */     AbstractDungeon.player.energy.energyMaster++;
/*    */   }
/*    */   
/*    */   public void onUnequip() {
/* 37 */     AbstractDungeon.player.energy.energyMaster--;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 42 */     return this.DESCRIPTIONS[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractRelic makeCopy() {
/* 47 */     return (AbstractRelic)new Mami();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/Mami.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */