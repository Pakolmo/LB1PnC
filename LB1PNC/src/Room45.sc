;;; Sierra Script 1.0 - (do not remove this comment)
(script# 45)
(include game.sh)
(use Main)
(use Intrface)
(use RFeature)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)
(use Inventory)
(use PncMenu)
(use DCIcon)
(public
	Room45 0
)
(synonyms
	(luggage case bag)
	(room bedroom nursery)
	(armoire armoire closet)
	(toy bear)
	(ethel person girl)
	(drawer chest dresser)
)

(local
	local0
	talkCount
	local2
	temp7
)
(instance Room45 of Room
	(properties
		picture 45
	)
	
	(method (init)
		(curRoom setRegions: 950)
		(= west 44)
		(super init:)
		(addToPics
			add:
				suit1
				bed
				lamp1
				lamp2
				wardrobe
				chest
				chair
				endtable
				bear
				dollhouse
				sofa
				shelf1
				shelf2
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				suit1
				lamp1
				lamp2
				bed
				chair
				endtable
				wardrobe
				sofa
				bear
				dollhouse
				shelf1
				shelf2
				chest
		)
		(switch currentAct
			(0
				(if (== [global368 4] 0)
					(= [global368 4] 1800)
				)
				(if (== global200 0)
					(LoadMany 143 243 221)
					(LoadMany 128 325 903)
					(= global208 8)
					(= [global377 3] 221)
					(Ethel
						ignoreActors: TRUE
						cycleSpeed: 1
						init:
						setScript: ethelActions
					)
					(eHead
						ignoreActors: TRUE
						cycleSpeed: 1
						setPri: 6
						cycleSpeed: 1
						init:
					)
					(Mouth
						ignoreActors: TRUE
						cycleSpeed: 1
						setPri: 6
						init:
						hide:
					)
				)
			)
		)
		(ego view: 0 posn: 1 124 init:)
	)
	
	(method (doit)
		(if (FirstEntry)
			(Print 45 0)
		)
		(if (and (> (ego x?) 126) (< (ego y?) 104))
			(ego setPri: 4)
		else
			(ego setPri: -1)
		)
		(if (< (ego x?) 60)
			(= vertAngle 0)
		else
			(= vertAngle 137)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript AVOIDER)
		(super dispose:)
	)
	
	(method (handleEvent event &tmp temp0)



		
		(cond
			(
				(and
					(== (event type?) evMOUSEBUTTON)
					(not (& (event modifiers?) emRIGHT_BUTTON))
				)
						
		
				(if (ClickedOnObj suit1 (event x?) (event y?)) 
					
					(event claimed: TRUE)
					(switch theCursor	
						(995
							(= temp7
							(PrintSpecial
								{Suit}
								#button {Open} 1
								#button {get} 2
							)
							)

						(switch temp7
							(1

								(DoVerb {open luggage})
										
							)
							(2

								(DoVerb {get luggage})	
							)
						)
						)
						(998				    
							(Print 45 14)
							(event claimed: TRUE)
						)
						(else
							(event claimed: FALSE)
						)
					)
				)


		
			(if (ClickedOnObj bed (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {bed})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)	
			
			
			(if (ClickedOnObj lamp1 (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {lamp})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
			(if (ClickedOnObj lamp2 (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {lamp})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)						
			(if (ClickedOnObj wardrobe (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {wardrobe})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)			
			(if (ClickedOnObj chest (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {chest})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
			(if (and (ClickedOnObj chair (event x?) (event y?)) 
				(== (event claimed?) FALSE))
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {chair})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
			(if (ClickedOnObj endtable (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {table})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
			(if (ClickedOnObj bear (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {bear})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
															
			
			
			
			(if (ClickedOnObj dollhouse (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {dollhouse})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
															
				
			
			
				(if (ClickedOnObj shelf1 (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {shelf})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
				)
															
				(if (ClickedOnObj shelf2 (event x?) (event y?)) 
				(event claimed: TRUE)
				(switch theCursor	
					(998
						(DoLook {shelf})
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
				
			
			
					(if (or (ClickedOnObj eHead (event x?) (event y?)) 
							(ClickedOnObj Ethel (event x?) (event y?)) )
				(event claimed: TRUE)
				(switch theCursor
					
					(602 ;necklace_
						(DoVerb {tell ethel about handkerchief})						
					)
					(604 ;monocle
						(DoVerb {tell ethel about monocle})						
					)
					
					(613 ;lantern_
						(DoVerb {tell ethel about lantern})						
					)
					(611 ;oilcan_
						(DoVerb {tell ethel about oilcan})						
					)
					(626 ;rolling_pin_
						(DoVerb {tell ethel about pin})						
					)
					(620 ;skeleton_key_
						(DoVerb {tell ethel about skeleton key})						
					)
					(627 ;poker_
						(DoVerb {tell ethel about poker})						
					)															
					(607 ;crowbar_
						(DoVerb {tell ethel about crowbar})						
					)
					(628 ;cigar_butt_
						(DoVerb {tell ethel about butt})						
					)
					(625 ;broken_record_
						(DoVerb {tell ethel about broken record})						
					)
					(601 ;notebook___pencil_
						(DoVerb {tell ethel about notebook})						
					)
					(603 ;_7_crackers________
						(DoVerb {tell ethel about crackers})						
					)
					(605 ;soup_bone_
						(DoVerb {tell ethel about soup bone})						
					)
					(606 ;valve_handle_
						(DoVerb {tell ethel about valve})						
					)
					(618 ;bullet_
						(DoVerb {tell ethel about bullet})						
					)
					(617 ;derringer__
						(DoVerb {tell ethel about derringer})						
					)
					(614 ;matches_
						(DoVerb {tell ethel about matches})						
					)
					(615 ;carrot_
						(DoVerb {tell ethel about carrot})						
					)
					(619 ;brass_key_
						(DoVerb {tell ethel about brass key})						
					)
					(616 ;diary_
						(DoVerb {tell ethel about diary})						
					)
					(621 ;crank_
						(DoVerb {tell ethel about crank})						
					)
					(612 ;cane_
						(DoVerb {tell ethel about cane})						
					)
					(622 ;pouch_
						(DoVerb {tell ethel about pouch})						
					)																																																																																
					(630 ;handkerchief_
						(DoVerb {tell ethel about handkerchief})
					)
					
					
							(930  ;gertrude
								(event type: 1 claimed: 1)
								(DoVerb {ask about Gertrude})
							)
							(931 ;Celie
								(event type: 1 claimed: 1)
								(DoVerb {ask about Celie})
							)	
							(932 ;Gloria
								(event type: 1 claimed: 1)
								(DoVerb {ask about Gloria})
							)													
							(933 ;Ethel
								(event type: 1 claimed: 1)
								(DoVerb {ask about Ethel})
							)	
							(934 ;Fifi
								(event type: 1 claimed: 1)
								(DoVerb {ask about Fifi})
							)	
							(935 ;Lillian
								(event type: 1 claimed: 1)
								(DoVerb {ask about Lillian})
							)																					
							(936 ;Clarence
								(event type: 1 claimed: 1)
								(DoVerb {ask about Clarence})
							)	
							(937 ;Feels
								(event type: 1 claimed: 1)
								(DoVerb {ask about Feels})
							)
							(938 ;Rudy
								(event type: 1 claimed: 1)
								(DoVerb {ask about Rudy})
							)	
							(939 ;Colonel
								(event type: 1 claimed: 1)
								(DoVerb {ask about Colonel})
							)
							(940 ;Jules
								(event type: 1 claimed: 1)
								(DoVerb {ask about Jules})
							)
					(996 ;talk
						(DoVerb {converse ethel})
					)
					(998
						(= temp7
							(PrintSpecial
								{Glass}
								#button {Examine} 1
								#button {handkerchief} 2
								#button {Ethel} 3
							)
							)

						(switch temp7
							(1

								(DoVerb {examine in glass})
										
							)
							(2

								(DoVerb {examine handkerchief})
										
							)						
							(3

								(DoVerb {look ethel})
										
							)						
						)
					)
					(995
						(= temp7
							(PrintSpecial
								{Glass}
								#button {Get glass} 1
								#button {Get handkerchief} 2

							)
							)

						(switch temp7
							(1

								(DoVerb {get glass})
										
							)
							(2

								(DoVerb {get handkerchief})
										
							)						
							(3

								(DoVerb {look ethel})
										
							)						
						)
					)
					(else
							(event claimed: FALSE)
						
					)
				)
		
			)
					
			
		
			
			)
			
			
			
			
			
				
			)














		(if (event claimed?) (return (event claimed?)))
		(return
			(if (== (event type?) saidEvent)
				(if
					(and
						global208
						(Said
							'ask,tell,hold,deliver,examine,get,kill,kiss,embrace,flirt>'
						)
					)
					(self setScript: (ScriptID 243 0))
					((self script?) handleEvent: event)
					(if (event claimed?) (return TRUE))
				)
				(cond 
					((Said 'examine[<around,at][/room]')
						(Print 45 0)
					)
					((Said 'examine/blind,curtain')
						(Print 45 1)
					)
					((Said 'close,open/blind,curtain')
						(CantDo)
					)
				)
			else
				FALSE
			)
		)
		
								

		

		
	)
	
	(method (newRoom n)
		(if (== [global368 4] 1)
			(= global125 1)
		)
		(super newRoom: n)
	)
)

(instance ethelActions of Script
	
	(method (doit)
		(super doit:)
		(if (and (== [global368 4] 1) (== local2 0))
			(= local2 1)
			(= global203 2)
			(= state 7)
			(= seconds 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel cel: 0 loop: 0 setCycle: EndLoop self)
			)
			(1
				(Mouth show: setCycle: Forward)
				(= seconds 3)
			)
			(2
				(Mouth hide:)
				(Ethel setCycle: BegLoop self)
			)
			(3
				(if (< (Random 1 100) 60) (= state -1))
				(= seconds (Random 6 12))
			)
			(4
				(eHead loop: (Random 1 2) setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(5
				(eHead setCycle: BegLoop)
				(= seconds (Random 6 12))
			)
			(6
				(Ethel loop: 4 cel: 0 setCycle: EndLoop)
				(= seconds (Random 6 12))
			)
			(7
				(Ethel loop: 4 cel: 0 setCycle: BegLoop)
				(= state -1)
				(= seconds (Random 6 12))
			)
			(8
				(eHead dispose:)
				(Mouth dispose:)
				(Ethel
					view: 325
					setLoop: 0
					ignoreActors: 0
					cycleSpeed: 0
					setCycle: Forward
					setAvoider: ((Avoider new:) offScreenOK: TRUE)
					setMotion: MoveTo -10 124 self
				)
			)
			(9
				(++ global200)
				(= global208 0)
				(Ethel setAvoider: 0 dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance lamp1 of RPicView
	(properties
		y 54
		x 231
		view 145
		priority 2
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of RPicView
	(properties
		y 67
		x 259
		view 145
		priority 3
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {lamp})
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 93
		x 207
		view 145
		cel 2
		priority 3
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'move/armoire,dollhouse')
				(Print 45 2)
			)
			((Said '(examine<in),open/armoire,(door<armoire)')
				(Print 45 3)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/armoire'))
				(Print 45 4)
				(event claimed: TRUE)
			)
		)
	)
)

(instance chest of RPicView
	(properties
		y 89
		x 27
		view 145
		cel 3
		priority 5
	)
	
	(method (handleEvent event)
		(if
			(or
				(MousedOn self event shiftDown)
				(Said 'examine[<at]/drawer')
			)
			(Print 45 5)
			(event claimed: TRUE)
		)
	)
)

(instance bed of RPicView
	(properties
		y 105
		x 125
		view 145
		cel 1
		priority 5
		signal ignrAct
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {bed})
		)
	)
)

(instance chair of RPicView
	(properties
		y 101
		x 65
		view 145
		cel 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {chair})
		)
	)
)

(instance endtable of RPicView
	(properties
		y 89
		x 87
		view 145
		cel 4
		priority 5
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {table})
		)
	)
)

(instance bear of RPicView
	(properties
		y 168
		x 291
		view 145
		cel 7
		priority 12
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'get/toy,animal')
				(Print 45 6)
			)
			((Said 'play')
				(Print 45 7)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/toy,animal'))
				(Print 45 8)
				(event claimed: TRUE)
			)
		)
	)
)

(instance dollhouse of RPicView
	(properties
		y 137
		x 256
		view 145
		cel 6
		priority 10
		signal ignrAct
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'examine<in/dollhouse,(cabin<doll)')
				(Print 45 9)
			)
			(
				(or
					(MousedOn self event shiftDown)
					(Said 'examine/(cabin<doll),dollhouse')
				)
				(Print 45 10)
				(event claimed: TRUE)
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 167
		x 160
		view 145
		cel 9
		priority 12
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(event claimed: TRUE)
			(DoLook {couch})
		)
	)
)

(instance shelf1 of RPicView
	(properties
		y 167
		x 89
		view 145
		cel 10
		priority 12
	)
	
	(method (handleEvent event)
		(if (or (MousedOn self event shiftDown) (Said 'examine/shelf'))
			(Print 45 11)
			(event claimed: TRUE)
		)
	)
)

(instance shelf2 of RPicView
	(properties
		y 167
		x 233
		view 145
		cel 8
		priority 12
	)
	
	(method (handleEvent event)
		(if (MousedOn self event shiftDown)
			(Print 45 11)
			(event claimed: TRUE)
		)
	)
)

(instance suit1 of RPicView
	(properties
		y 111
		x 131
		view 145
		cel 11
	)
	
	(method (handleEvent event)
		(cond 
			((Said 'open,(examine<in)/luggage') ;995
				(Print 45 12)
			)
			((Said 'get/luggage') ;995
				(Print 45 13)
			)
			((or (MousedOn self event shiftDown) (Said 'examine/luggage')) ;998
				(Print 45 14)
				(event claimed: TRUE)
			)
		)
	)
)

(instance Ethel of Actor
	(properties
		y 100
		x 68
		view 327
		illegalBits $0000
	)
	
	(method (handleEvent event)
		(return
			(cond 
				((Said 'examine<in/drink,glass')
					(Print 45 15)
				)
				((Said 'examine/drink,glass,deliver,handkerchief')
					(Print 45 16)
				)
				((Said 'get>')
					(cond 
						((Said '/drink,glass')
							(Print 45 17)
						)
						((Said '/handkerchief')
							(Print 45 18)
						)
					)
				)
				((and (MousedOn self event shiftDown) (not (& global207 $0008)))
					(event claimed: TRUE)
					(DoLook {ethel})
				)
				(
					(and
						(& global207 $0008)
						(or (MousedOn self event shiftDown) (Said 'examine/ethel'))
					)
					(event claimed: TRUE)
					(Print 45 19)
				)
				((Said 'converse/ethel')
					(= theTalker talkETHEL)
					(switch talkCount
						(0
							(Say 1 45 20)
							(= theTalker talkLAURA)
							(Say 1 45 21)
						)
						(1 (Say 1 45 22))
						(else  (Say 1 45 23))
					)
					(++ talkCount)
				)
			)
		)
	)
)

(instance eHead of Prop
	(properties
		y 64
		x 65
		view 327
		loop 1
	)
)

(instance Mouth of Prop
	(properties
		y 57
		x 66
		view 327
		loop 3
	)
)
