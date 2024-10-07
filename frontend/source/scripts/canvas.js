const canvas = document.getElementById('canvas');
const ctx    = canvas.getContext('2d');
canvas.style.position = 'absolute';
canvas.height = 360;
canvas.width = 360
ctx.font = "16px Times New Roman";
ctx.fillStyle = "#F92C85"
ctx.beginPath()
ctx.arc(180, 180, 120, 0,-Math.PI/2, true)
ctx.lineTo(180, 180)
ctx.lineTo(330, 180)
ctx.moveTo(180, 180)
ctx.lineTo(120, 180)
ctx.lineTo(180, 240)
ctx.lineTo(180, 180)
ctx.fill()
ctx.fillRect(180, 180, 120, 60)
ctx.beginPath();
canvas_arrow(ctx, 30, 180, 330, 180);
canvas_arrow(ctx, 180, 330, 180, 30)
ctx.moveTo(60, 177)
ctx.lineTo(60,183)
ctx.moveTo(120, 177)
ctx.lineTo(120,183)
ctx.moveTo(240, 177)
ctx.lineTo(240,183)
ctx.moveTo(300, 177)
ctx.lineTo(300,183)
ctx.moveTo(177, 60)
ctx.lineTo(183, 60)
ctx.moveTo(177, 120)
ctx.lineTo(183, 120)
ctx.moveTo(177, 240)
ctx.lineTo(183, 240)
ctx.moveTo(177, 300)
ctx.lineTo(183, 300)
ctx.stroke();
ctx.strokeText("-R", 52, 175)
ctx.strokeText("-R/2", 108, 175)
ctx.strokeText("R", 295, 175)
ctx.strokeText("R/2", 232, 175)
ctx.strokeText("R", 185, 65)
ctx.strokeText("R/2", 185, 125)
ctx.strokeText("-R/2", 185, 244)
ctx.strokeText("-R", 185, 304)
function canvas_arrow(context, fromx, fromy, tox, toy) {
    const headmen = 10;
    const dx = tox - fromx;
    const dy = toy - fromy;
    const angle = Math.atan2(dy, dx);
    context.moveTo(fromx, fromy);
    context.lineTo(tox, toy);
    context.lineTo(tox - headmen * Math.cos(angle - Math.PI / 6), toy - headmen * Math.sin(angle - Math.PI / 6));
    context.moveTo(tox, toy);
    context.lineTo(tox - headmen * Math.cos(angle + Math.PI / 6), toy - headmen * Math.sin(angle + Math.PI / 6));

}