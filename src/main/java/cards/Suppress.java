/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ import java.util.Iterator;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Suppress extends CustomCard {
/* 20 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Suppress"); public static final String ID = "Suppress";
/* 21 */   public static final String NAME = cardStrings.NAME;
/* 22 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Suppress_skill.png";
/*    */   private static final int COST = 0;
/*    */   
/*    */   public Suppress() {
/* 27 */     super("Suppress", NAME, "img/cards/Suppress_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
/* 28 */     this.baseMagicNumber = 0;
/* 29 */     this.magicNumber = this.baseMagicNumber;
/* 30 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     Iterator<AbstractMonster> monsterGroup = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 36 */     while (monsterGroup.hasNext()) {
/* 37 */       AbstractMonster mo = monsterGroup.next();
/* 38 */       if (Patch.countCurse() >= 5) {
/* 39 */         addToBot((AbstractGameAction)new StunMonsterAction(mo, (AbstractCreature)p, 1)); continue;
/*    */       } 
/* 41 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, 1, false), 1, true, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 46 */     this.baseMagicNumber = Patch.countCurse();
/* 47 */     super.calculateCardDamage(mo);
/*    */   }
/*    */   public void applyPowers() {
/* 50 */     this.baseMagicNumber = Patch.countCurse();
/* 51 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 55 */     return (AbstractCard)new Suppress();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 59 */     if (!this.upgraded) {
/* 60 */       upgradeName();
/* 61 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 62 */       initializeDescription();
/* 63 */       this.selfRetain = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Suppress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */