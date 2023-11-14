;;; Sierra Script 1.0 - (do not remove this comment)
(script# 237)
(include game.sh)
(use Main)
(use atsgl)
(use Intrface)
(use Avoider)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	wcargue 0
)
(synonyms
	(butt cigarette)
	(men people)
)

(local
	clarenceTalkCount
	wilburTalkCount
	local2
	local3
	local4
	local5
)
(procedure (localproc_000c)
	(cast eachElementDo: #hide)
	(DrawPic 992 IRISIN TRUE 0)
)

(procedure (localproc_0023)
	(DrawPic 34 IRISOUT TRUE 0)
	(addToPics doit:)
	(cast eachElementDo: #show)
	(WHead hide:)
)

(procedure (WilburPrint)
	(Wilbur loop: 3 setCycle: Forward)
	(WHead view: 404 loop: 5 setCycle: Forward)
	(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
	(Print &rest
		#at 171 150
		#font 4
		#width 125
		#mode teJustCenter
		#dispose
	)
)

(procedure (ClarencePrint)
	(Clarence loop: 2 setCycle: Forward)
	(CHead view: 404 loop: 3 setCycle: Forward)
	(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
	(Print &rest
		#at 40 150
		#font 4
		#width 125
		#mode teJustCenter
		#dispose
	)
)

(instance wcargue of Region
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(LoadMany 142 7 8)
		(LoadMany 143 243 247 248)
		(= global208 192)
		(= [global377 6] 248)
		(= [global377 7] 247)
		(Load VIEW 404)
		(Clarence init:)
		(CHead init:)
		(Wilbur init:)
		(WHead ignoreActors: 1 init:)
		(Smoke init: hide:)
		(self setScript: argue)
	)
	
	(method (doit)
		(if (and (== global172 100) (not local5))
			(= local5 1)
			(cls)
			(WilburPrint 237 0)
		)
		(if (== global172 110) (cls))
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
					(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
					
	
				(if (or (ClickedOnObj Clarence (event x?) (event y?)) 	
						(ClickedOnObj CHead (event x?) (event y?)))
					(event claimed: TRUE)
					(switch theCursor	
					
					(602 ;necklace_
						(DoVerb {tell Clarence about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell Clarence about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell Clarence about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell Clarence about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell Clarence about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell Clarence about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell Clarence about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell Clarence about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell Clarence about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell Clarence about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell Clarence about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell Clarence about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell Clarence about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell Clarence about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell Clarence about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell Clarence about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell Clarence about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell Clarence about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell Clarence about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell Clarence about diary})						
					)
					(621 ;crank_
						(DoVerb {tell Clarence about crank})						
					)
					(612 ;cane_
						(DoVerb {tell Clarence about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell Clarence about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell Clarence about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Rudolph}) 
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about Jules})
								
							)	
		
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask Clarence about blaze})
							)															
						(996 ;talk
							(DoVerb {converse Clarence})
						)
						(994
								(DoVerb {hear Clarence})
						)	
						(998
								(DoVerb {look Clarence})
						)
						(else				
									(event claimed: FALSE)
								)
							)
						
						)
			
				(if (or (ClickedOnObj Wilbur (event x?) (event y?)) 
					(ClickedOnObj WHead (event x?) (event y?)) 	)
					(event claimed: TRUE)
					(switch theCursor	
					(998
						(DoVerb {look wilbur})
					)
					(996
						(DoVerb {converse wilbur})
					)
					(994
						(DoVerb {hear wilbur})
					)
											
					
					(602 ;necklace_
						(DoVerb {tell wilbur about necklace})						
					)
					(604 ;monocle
						(DoVerb {tell wilbur about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell wilbur about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell wilbur about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell wilbur about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell wilbur about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell wilbur about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell wilbur about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell wilbur about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell wilbur about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell wilbur about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell wilbur about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell wilbur about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell wilbur about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell wilbur about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell wilbur about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell wilbur about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell wilbur about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell wilbur about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell wilbur about diary})						
					)
					(621 ;crank_
						(DoVerb {tell wilbur about crank})						
					)
					(612 ;cane_
						(DoVerb {tell wilbur about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell wilbur about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell wilbur about handkerchief})
					)
											
						
						
						
						
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Wilbur})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about Jules})
							)											
							(941 ;Dog
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about beauregard})
							)													
							(942 ;Parrot
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about polly})
							)							
							(943 ;Horse
								(event type: 1 claimed: 1)
								(DoVerb {ask wilbur about blaze})
							)							
					(else
						(event claimed: FALSE)
						)																	
						)
					)		
						

		
		
			)
			)
		
	
	
	
	
	
			
		
		
		
		
		
		
		
		
		
		
		
		
		(return (if (event claimed?) (return TRUE) else FALSE))
	)
)

(instance argue of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(User canInput: FALSE)
				(if (< gCurRoomNum_2 6)
					(++ gCurRoomNum_2)
				else
					(= gCurRoomNum_2 3)
				)
				(switch gCurRoomNum_2
					(1
						(ClarencePrint 237 1)
						(= seconds 6)
					)
					(2
						(WilburPrint 237 2)
						(= seconds 6)
					)
					(3
						(ClarencePrint 237 3)
						(= seconds 4)
					)
					(4
						(WilburPrint 237 4)
						(= seconds 3)
					)
					(5
						(ClarencePrint 237 5)
						(= seconds 5)
					)
					(else 
						(WilburPrint 237 6)
						(= seconds 3)
					)
				)
			)
			(2
				(cls)
				(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
				(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
				(switch gCurRoomNum_2
					(1
						(Clarence setCycle: 0)
						(= seconds 1)
					)
					(2
						(Wilbur setCycle: 0)
						(= seconds 1)
					)
					(3
						(Wilbur loop: 1 cel: 0 setCycle: EndLoop self)
						(Clarence loop: 0 cel: 3 setCycle: BegLoop)
					)
					(4
						(Wilbur loop: 1 cel: 0 setCycle: EndLoop self)
					)
					(else 
						(Wilbur cel: 3 setCycle: BegLoop self)
					)
				)
			)
			(3
				(switch gCurRoomNum_2
					(1
						(ClarencePrint 237 7)
						(= seconds 4)
					)
					(2
						(WilburPrint 237 8)
						(= seconds 4)
					)
					(3
						(WilburPrint 237 9)
						(= seconds 3)
					)
					(else  (= cycles 1))
				)
			)
			(4
				(CHead view: 402 loop: 8 cel: 2 setCycle: 0)
				(WHead view: 425 loop: 5 cel: 0 setCycle: 0)
				(Wilbur setScript: wilActions)
				(Clarence setScript: clarActions)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance wilActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (Wilbur loop?) 1)
					(Wilbur loop: 1 cel: 3 setCycle: BegLoop self)
				else
					(= cycles 1)
				)
			)
			(1
				(Wilbur loop: 9 cel: 0 cycleSpeed: 1 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(2
				(Wilbur setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(3
				(WHead view: 425 loop: 5 cycleSpeed: 1 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(4
				(WHead view: 425 setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(5
				(WHead view: 425 loop: 7 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(6
				(WHead view: 425 setCycle: BegLoop)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance clarActions of Script
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local3 1)
					(= local3 2)
					(cls)
					(Wilbur loop: 1 setCycle: BegLoop)
				)
				(if (> (Clarence loop?) 1)
					(Clarence loop: 0 cel: 3 setCycle: BegLoop self)
					(= state -1)
				else
					(Clarence loop: 4 cel: 9 cycleSpeed: 1 setCycle: EndLoop self)
				)
			)
			(1
				(Clarence loop: 6 cel: 0 setCycle: EndLoop self)
			)
			(2
				(Smoke show: setPri: 7 cycleSpeed: 1 setCycle: EndLoop self)
			)
			(3
				(if (< local2 2)
					(++ local2)
					(= state 1)
				else
					(= local2 0)
				)
				(= cycles 1)
			)
			(4
				(= seconds (Random 6 12))
				(cond 
					((and (< (Random 1 100) 40) (== local3 0))
						(= local3 1)
						(WilburPrint 237 10)
						(= seconds 4)
					)
					((< (Random 1 100) 60)
						(= state 0)
					)
				)
				(Smoke hide:)
				(Clarence setCycle: BegLoop)
			)
			(5
				(if (== local3 1)
					(= local3 2)
					(cls)
					(Wilbur loop: 1 setCycle: BegLoop)
				)
				(CHead loop: 8 cycleSpeed: 1 setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(6
				(CHead setCycle: EndLoop)
				(= state 0)
				(= seconds (Random 6 12))
			)
		)
	)
)

(instance goSee of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(HandsOff)
				(WHead hide:)
				(Wilbur
					view: 420
					setCycle: Walk
					cycleSpeed: 0
					setPri: -1
					illegalBits: cWHITE
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo 300 120 self
				)
			)
			(1
				(= saveDisabled TRUE)
				(localproc_000c)
				(= seconds 5)
			)
			(2
				(localproc_0023)
				(Print 237 11 #dispose)
				(if (ego inRect: 150 98 175 102)
					(ego setMotion: MoveTo (+ (ego x?) 10) (ego y?))
				)
				(Wilbur setMotion: MoveTo 157 100 self)
				(= saveDisabled FALSE)
			)
			(3
				(cls)
				(= theTalker talkWILBUR)
				(Say 1 237 12)
				(HandsOn)
				(Wilbur setAvoider: 0)
				(Wilbur view: 425 loop: 1 setScript: wilActions)
				(Clarence setScript: clarActions)
				(WHead show:)
			)
		)
	)
)

(instance CHead of Prop
	(properties
		y 104
		x 114
		z 40
		view 402
		loop 8
		cel 2
	)
)

(instance Clarence of Prop
	(properties
		y 104
		x 114
		view 402
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if (< (ego distanceTo: Clarence) (ego distanceTo: Wilbur))
			(= global214 64)
		else
			(= global214 128)
		)
		(= theTalker talkCLARENCE)
		(cond 
			((Said 'examine/butt')
				(Bset fExaminedCigar)
				(Print 237 13)
			)
			((Said 'get/butt')
				(Print 237 14)
			)
			((Said 'examine/fellow')
				(event claimed: TRUE)
				(if (== global214 64)
					(DoLook {clarence})
				else
					(DoLook {wilbur})
				)
			)
			((and (MousedOn self event shiftDown) (not (& global207 $0040)))
				(event claimed: TRUE)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event shiftDown) (Said 'examine/attorney'))
				)
				(event claimed: TRUE)
				(Print 237 15)
			)
			(
				(or
					(Said 'converse/attorney')
					(and (== global214 64) (Said 'converse/fellow'))
				)
				(switch clarenceTalkCount
					(0 (Say 1 237 16))
					(1 (Say 1 237 17))
					(2 (Say 1 237 18))
					(else  (Print 237 19))
				)
				(++ clarenceTalkCount)
			)
			((Said 'ask[/attorney]/c<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 19 237 20)
			)
			((Said 'hear/attorney,c')
				(Print 237 21)
			)
		)
	)
)

(instance WHead of Prop
	(properties
		y 100
		x 158
		z 39
		view 425
		loop 5
	)
)

(instance Wilbur of Actor
	(properties
		y 100
		x 157
		view 425
		loop 1
	)
	
	(method (handleEvent event)
		(= theTalker talkWILBUR)
		(cond 
			((and (Btst fSawDeadGuest) (Said 'tell[/c]/gertie<about'))
				(= theTalker talkWILBUR)
				(if (& deadGuests deadGERTRUDE)
					(if (& global145 $0004)
						(Say 1 237 22)
					else
						(Say 1 237 23)
						(|= global145 $0004)
						(Wilbur setScript: goSee)
						(Clarence setScript: 0)
					)
				else
					(event claimed: FALSE)
				)
			)
			((Said 'examine/men')
				(Print 237 15)
			)
			((Said 'examine,converse/person,men')
				(Print 237 24)
			)
			((Said 'converse/men')
				(Print 237 25)
			)
			((and (not (& global207 $0080)) (MousedOn self event shiftDown))
				(event claimed: TRUE)
				(DoLook {wilbur})
			)
			(
				(and
					(& global207 $0080)
					(or (MousedOn self event shiftDown) (Said 'examine/c,men'))
				)
				(event claimed: TRUE)
				(Print 237 15)
			)
			((Said 'converse/c,fellow')
				(switch wilburTalkCount
					(0 (Say 1 237 26))
					(1 (Say 1 237 27))
					(2 (Say 1 237 28))
					(else  (Say 1 237 29))
				)
				(++ wilburTalkCount)
			)
			((Said 'ask[/c]/attorney<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 4 237 20)
			)
		)
	)
)

(instance Smoke of Prop
	(properties
		y 62
		x 126
		view 402
		loop 9
	)
)
