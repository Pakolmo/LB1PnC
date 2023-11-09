;;; Sierra Script 1.0 - (do not remove this comment)
(script# 213) ;OK
(include game.sh)
(use Main)
(use Intrface)
(use Game)
;;;(use Actor)

(public
	fireReg 0
)
(local
	temp7
)
;;;(instance Chimenea of Actor)
(instance fireReg of Region
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		
	
;;;		
;;;						(cond
;;;			(
;;;				(and
;;;					(== (event type?) evMOUSEBUTTON)
;;;					(not (& (event modifiers?) emRIGHT_BUTTON))
;;;				)
;;;				
;;;	
;;;				(if (ClickedOnObj Chimenea (event x?) (event y?)) 
;;;					
;;;					(event claimed: TRUE)
;;;					(switch theCursor	
;;;						(998		
;;;							(= temp7
;;;								(PrintSpecial
;;;									{Chimenea}
;;;									#button {Examine} 1
;;;									#button {Examine in} 2
;;;									#button {Examine fire} 3
;;;;;;									{Fireplace}
;;;;;;									#button {Examine} 1
;;;;;;									#button {Examine in} 2							
;;;;;;									#button {Examine fire} 3
;;;								)
;;;							)
;;;							(switch temp7
;;;								(1
;;;								    (DoVerb {examine fireplace})
;;;								)
;;;								(2
;;;									(DoVerb {examine in fireplace})
;;;								)
;;;								(3
;;;									(DoVerb {examine fire})
;;;								)								
;;;								(else
;;;									(event claimed: FALSE)
;;;								)
;;;							)
;;;						)
;;;						(995
;;;							(DoVerb {get fire})
;;;						)								
;;;								(else
;;;									(event claimed: FALSE)
;;;								)
;;;							)
;;;						)
;;;		
;;;		
;;;		
;;;			)
;;;						)
;;;		
;;;		
;;;		
		
		(if (event claimed?) (return))
		(if (== (event type?) saidEvent)
			(cond 
				((Said 'examine>')
					(cond 
						((Said '<in/fireplace')
							(switch curRoomNum
								(31
									(Print 213 0)
								)
								(44
									(Print 213 0)
								)
								(42
									(Print 213 1)
								)
								(else 
									(if (< currentAct 4)
										(Print 213 2)
									else
										(Print 213 1)
									)
								)
							)
						)
						((Said '/fireplace')
							(Print 213 3)
						)
						((Said '/fire')
							(cond 
								((or (== curRoomNum 32) (== curRoomNum 34))
									(if (< currentAct 4)
										(Print 213 2)
									else
										(Print 213 1)
									)
								)
								((== curRoomNum 42)
									(Print 213 1)
								)
								(else
									(event claimed: FALSE)
								)
							)
						)
						((Said '/mantel')
							(if (== curRoomNum 34)
								(Print 213 4)
							else
								(Print 213 5)
							)
						)
					)
				)
				((Said 'get/fire')
					(if (or (== curRoomNum 32) (== curRoomNum 34))
						(Print 213 6)
					else
						(Print 213 7)
					)
				)
			)
		)
	)
)
