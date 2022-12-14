varying vec2 v_texCoords;
uniform sampler2D u_texture;
varying vec4 v_color;

void main() {
//    vec2 pixel = gl_FragCoord;
    vec2 resolution = vec2(640.0, 480.0);
    vec2 texSize = vec2(32.0, 32.0);
//    vec2 uv = gl_FragCoord / resolution;
    vec2 uv = vec2(gl_FragCoord.x / resolution.x, -gl_FragCoord.y / resolution.y);
    gl_FragColor = texture2D(u_texture, uv);
//    vec2 uv = floor(pixel) + 0.5;
//    uv += 1.0 - clamp((1.0 - fract(pixel)), 0.0, 1.0);
//    vec2 texSize = vec2(32.0, 32.0);
//    vec2 resolution = vec2(640.0, 480.0);
//    uv.xy -= resolution.xy ;
//    gl_FragColor = v_color * texture2D(u_texture, uv / texSize);
}