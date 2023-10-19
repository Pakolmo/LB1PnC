;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Intrface)
(use System)

(local
	yesI
	;useMonocleI
	;useToggle
	selI
	lookI
	useI
	oldCur
)

(class InvI of Object
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)

	(method (saidMe)
		(Said said)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(= owner id)
		(return self)
	)

	(method (showSelf)
		(ShowView (if description description else name) view loop cel)
	)

	(method (changeState newState)
		(if script
			(script changeState: newState)
		)
	)
)

(class Inv of Set
	(properties
		carrying {}
		empty {You are carrying nothing!}
	)

	(method (init)
		(= inventory self)
	)

	(method (saidMe)
		(self firstTrue: #saidMe)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		(invD text: carrying doit: whom)
	)
)

(instance invD of Dialog
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (inventory first:)))
			temp5
			((= temp5 (inventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(if (temp6 ownedBy: param1)
				(++ temp3)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: smallFont
							setSize:
							yourself:
						)
				)
				(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
					(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				)
				(if
					(>
						(+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1))
						140
					)
					(= temp1 4)
					(+= temp0 (+ temp2 10))
					(= temp2 0)
				)
			)
		)
		(if (not temp3)
			(self dispose:)
			(return 0)
		)
		(= window systemWindow)
		(self setSize:)
		(= selI (DButton new:))
		(selI 
;;;			text: "Select", ;ENGLISH
			text: "Elegir", ;SPANISH
			setSize:,
			moveTo: 
				;(- nsRight (+ MARGIN (yesI nsRight?)))
				(+ nsLeft (+ 4 (selI nsLeft?)))
				nsBottom
		)
		(= lookI (DButton new:))
		(lookI 
;;;			text: "Look_", ;English
			text: "Mirar", ;Spanish
			setSize:,
			moveTo: 
				(+ nsLeft (+ 4 (selI nsRight?)))
				nsBottom
		)
		(= useI (DButton new:))
		(useI 
;;;			text: "Use", ;ENGLISH
			text: "Usar", ;SPANISH
			setSize:,
			moveTo: 
				(+ nsLeft (+ 4 (lookI nsRight?)))
				nsBottom
		)
		(= yesI (DButton new:))
		(yesI 
			text: "OK", 
			setSize:,
			moveTo: 
				(+ nsLeft (+ 4 (useI nsRight?) 5))
				nsBottom
		)
		
		(self add: selI lookI useI yesI, setSize:, center:)
		(return temp3)
	)

	(method (doit param1 &tmp temp0 [str 200])
;;;		(cond
;;;			((== param1 777) ;inv use hack
;;;				(= useToggle 1)
;;;				(= useInvItem 0)
;;;				(= useInvItem2 0)
;;;				(= param1 ego)
;;;			)
;;;			((== param1 888) ;inv on inv from right-click ego
;;;				(= useToggle 0)
;;;				(= useInvItem 0)
;;;				(= useInvItem2 0)
;;;				(= param1 ego)
;;;			)
;;;			(else
;;;				(= useToggle 0)
;;;			)
;;;		)
		(ego get: 0 1 2 3 4 5 6 18)
		(ego get: 24 25 26 27 28 29 30 31 32 33)
		(if (not (self init: param1))
			(Print (inventory empty:))
			(return)
		)
		(self open: 4 15)
		(= temp0 yesI)
;;;		(repeat
;;;			(if
;;;				(or
;;;					(not (= temp0 (super doit: temp0)))
;;;					(== temp0 -1)
;;;					(== temp0 yesI)
;;;				)
;;;				(break)
;;;			)
;;;			(if (== useInvItem2 0)
;;;				((temp0 value:) showSelf:)
;;;			else
;;;				(= useInvItem ((temp0 value:) name?))
;;;				(break)
;;;			)
;;;		)
;;;		(if (== temp0 yesI)
;;;			(= useInvItem 0)
;;;		)



		(theGame setCursor: 993) ;start with select arrow
		
		(repeat
			(= temp0 (super doit:temp0))

			;These returns signal end of dialog
			(if (or (not temp0) (== temp0 -1) (== temp0 yesI))
				(if
					(or
						(== theCursor 998)
						(== theCursor 993)
					) 
					(= theCursor oldCur)
					(theGame setCursor: oldCur (HaveMouse))
				)
				(break)
			)
			
			(if
				(or
					(== temp0 selI)
					(== temp0 lookI)
					(== temp0 useI)
					(== temp0 yesI) 
				)
				(cond 
					((== temp0 selI)
						(if (!= theCursor 993)
							(theGame setCursor: 993)
						)
					)
					((== temp0 lookI)
						(if (!= theCursor 998)
							(theGame setCursor: 998)
						)
					)
					((== temp0 useI)
						(if (!= theCursor 995)
							(theGame setCursor: 995)
						)
					)
					(else
						;do nothing
					)
				)
			else	
				(switch theCursor
					(993 ;set cursor to selected item and print desc.
						(= itemIcon ((temp0 value?) view?))
						(theGame setCursor: ((temp0 value?) view?))
					)
					(995 ;use
						(cond
							((== ((temp0 value?) view?) 133) ;used bombinstructions
									(Print 800 53 #font smallFont)		
							)
							(else
;;;								(Print {You don't need to use that item.})
								(Print {No es necesario utilizar ese objeto.})
							)
						)
					)
					(998 ;look at item	
						((temp0 value?) showSelf:) ;display the inventory item normally.
;;;						(if (== ((el value?) view?) 133) ;looked at bombInstructions
;;;							(Print 800 53 #font smallFont)
;;;						else
;;;							((el value?) showSelf:)
;;;						)
					)
					(else
;;;						(Print {You can't use those items together.}) ;English
						(Print {No puedes usar esos dos objetos juntos.}) ;Spanish
					)
				)
			)
		)
		(self dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0040 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

