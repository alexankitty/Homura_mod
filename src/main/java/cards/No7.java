/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.ServantAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class No7 extends CustomCard {
/*    */   public static final String ID = "No7";
/* 22 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No7");
/* 23 */   public static final String NAME = cardStrings.NAME;
/* 24 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/No7_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 6;
/*    */   private static final int UPGRADE_PLUS_DMG = 2;
/*    */   
/*    */   public No7() {
/* 31 */     super("No7", NAME, "img/cards/No7_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
/* 32 */     this.baseDamage = 6;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {}
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     if (m == null) {
/*    */       return;
/*    */     }
/* 44 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */     
/* 46 */     if (m.type != AbstractMonster.EnemyType.BOSS)
/*    */     {
/* 48 */       if (this.upgraded) {
/* 49 */         for (AbstractPower pow : m.powers) {
/* 50 */           if (pow.type == AbstractPower.PowerType.BUFF && 
/* 51 */             !pow.ID.equals("Fading") && 
/* 52 */             !pow.ID.equals("Shifting") && 
/* 53 */             !pow.ID.equals("Life Link")) {
/* 54 */             AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, pow));
/*    */           }
/*    */         }
/*    */       
/* 58 */       } else if (!m.powers.isEmpty()) {
/* 59 */         ArrayList<AbstractPower> pows = new ArrayList<>();
/* 60 */         for (AbstractPower pow : m.powers) {
/* 61 */           if (pow.type == AbstractPower.PowerType.BUFF && 
/* 62 */             !pow.ID.equals("Fading") && 
/* 63 */             !pow.ID.equals("Shifting") && 
/* 64 */             !pow.ID.equals("Life Link")) {
/* 65 */             pows.add(pow);
/*    */           }
/*    */         } 
/* 68 */         if (!pows.isEmpty()) {
/* 69 */           AbstractPower po = pows.get((int)(Math.random() * pows.size()));
/* 70 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, po));
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 80 */     addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 84 */     return (AbstractCard)new No7();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 88 */     if (!this.upgraded) {
/* 89 */       upgradeName();
/* 90 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 91 */       initializeDescription();
/* 92 */       upgradeDamage(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No7.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */